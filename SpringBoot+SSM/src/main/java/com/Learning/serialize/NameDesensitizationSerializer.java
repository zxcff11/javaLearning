package com.Learning.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import cn.hutool.core.util.DesensitizedUtil;

import java.io.IOException;

public class NameDesensitizationSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String Name, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String nameDesensitization = DesensitizedUtil.chineseName(Name);
        jsonGenerator.writeString(nameDesensitization);
    }
}
