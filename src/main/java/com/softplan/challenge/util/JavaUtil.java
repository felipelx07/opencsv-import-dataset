package com.softplan.challenge.util;

import com.softplan.challenge.model.Caers;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
public class JavaUtil {

    public static List<Field> getAllCaersFields() {
        List<Field> fields = new ArrayList<>();
        Class clazz = Caers.class;
        while (clazz != Object.class) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return fields;
    }

    public static boolean haveSpecialCharacters(String string) {
        Pattern p = Pattern.compile("[^a-z0-9' ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(string);
        return m.find();
    }
}
