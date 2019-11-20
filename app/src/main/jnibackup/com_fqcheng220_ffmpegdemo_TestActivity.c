//
// Created by Administrator on 2019/11/20.
//
#include "com_fqcheng220_ffmpegdemo_TestActivity.h"

#include <stdio.h>

#ifdef ANDROID
#include <jni.h>
#include <android/log.h>
#define LOGE(format, ...)  __android_log_print(ANDROID_LOG_ERROR, "(>_<)", format, ##__VA_ARGS__)
#define LOGI(format, ...)  __android_log_print(ANDROID_LOG_INFO,  "(^_^)", format, ##__VA_ARGS__)
#else
#define LOGE(format, ...)  printf("(>_<) " format "\n", ##__VA_ARGS__)
#define LOGI(format, ...)  printf("(^_^) " format "\n", ##__VA_ARGS__)
#endif

JNIEXPORT void JNICALL Java_com_fqcheng220_ffmpegdemo_TestActivity_testNativeMethod1
  (JNIEnv * env , jobject object, jstring input_jstr, jstring output_jstr){
     (*env)->NewStringUTF(env,"I am From Native C");

     int ret;
     char input_str[500]={0};
     char output_str[500]={0};
     sprintf(input_str,"%s",(*env)->GetStringUTFChars(env,input_jstr, NULL));
     sprintf(output_str,"%s",(*env)->GetStringUTFChars(env,output_jstr, NULL));

     LOGE("I am From Native C input_str=%s,output_str=%s",input_str,output_str);
     return;
 }