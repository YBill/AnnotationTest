package com.bill.jsonlib;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;

/**
 * Created by Bill on 2018/7/6.
 */

@SupportedAnnotationTypes({"com.bill.jsonlib.Seriable"})
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class JsonProcessor extends AbstractProcessor {

    private Elements mElementUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mElementUtils = processingEnvironment.getElementUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(Seriable.class);
        Map<String, List<VariableElement>> map = new HashMap<>();
        for (Element element : elements) {
            ElementKind kind = element.getKind();
            if (kind == ElementKind.CLASS) {
                TypeElement typeElement = (TypeElement) element;
                String qualifiedName = typeElement.getQualifiedName().toString();
                List<VariableElement> fileds = new ArrayList<>();
                map.put(qualifiedName, fileds);
            } else if (kind == ElementKind.FIELD) {
                VariableElement variableElement = (VariableElement) element;
                TypeElement typeElement = (TypeElement) variableElement.getEnclosingElement();
                String qualifiedName = typeElement.getQualifiedName().toString();
                List<VariableElement> fileds = map.get(qualifiedName);
                if (fileds == null) {
                    fileds = new ArrayList<>();
                    map.put(qualifiedName, fileds);
                }
                fileds.add(variableElement);
            }
        }

        Set<String> strSet = map.keySet();
        for (String key : strSet) {
            if (map.get(key).size() == 0) {
                TypeElement typeElement = mElementUtils.getTypeElement(key);
                List<? extends Element> allMembers = mElementUtils.getAllMembers(typeElement);
                if (allMembers.size() > 0) {
                    map.get(key).addAll(ElementFilter.fieldsIn(allMembers));
                }
            }
        }

        generateCodes(map);

        return true;
    }

    private void generateCodes(Map<String, List<VariableElement>> maps) {
        File dir = new File("f://Animation");
        if (!dir.exists()) {
            dir.mkdir();
        }
        for (String key : maps.keySet()) {
            File file = new File(dir, key.replaceAll("\\.", "_") + ".txt");
            try {
                FileWriter fw = new FileWriter(file);
                fw.append("{").append("class:").append("\"" + key + "\"").append(",\n ");
                fw.append("fields:\n {\n");
                List<VariableElement> fields = maps.get(key);

                for (int i = 0; i < fields.size(); i++) {
                    VariableElement field = fields.get(i);
                    fw.append("  ").append(field.getSimpleName()).append(":").append("\"" + field.asType().toString() + "\"");
                    if (i < fields.size() - 1) {
                        fw.append(",");
                        fw.append("\n");
                    }
                }
                fw.append("\n }\n");
                fw.append("}");
                fw.flush();
                fw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
