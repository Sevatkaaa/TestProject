package com.test;

import com.google.gson.Gson;

public class JsonConverter {
    public static void main(String[] args) {
//        String jsonString = "{operatingSystem=Android OS 8.0.0 / API-26 (R16NW/G950FXXU3CRH1), deviceModel=samsung SM-G950F, graphicsDeviceName=Mali-G71, graphicsDeviceVersion=OpenGL ES 3.2 v1.r9p0-01rel0.2498e584901afb9257be0d365ada85fa, maxTextureSize=8192, systemMemorySize=3458, graphicsMemorySize=1024, graphicsMultiThreaded=false, processorCount=8, processorName=ARMv7 VFPv3 NEON, supports3DTextures=true, supportsRenderTextures=false, supportedRenderTargetCount=1}";
        String jsonString = "{value=1_2_3}";
        Gson g = new Gson();
        JsonTest p = g.fromJson(jsonString, JsonTest.class);
        System.out.println(p.value);
        System.out.println(p.val);
    }
}
class JsonTest {
    String value;
    Integer val;
}
