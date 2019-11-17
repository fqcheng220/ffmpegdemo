//
// Created by Administrator on 2019/11/12 0012.
//

#include "com_fqcheng220_ffmpegdemo_MainActivity.h"
//#include <studio.h>

#include "libavcodec/avcodec.h"
#include "libavformat/avformat.h"

#ifdef ANDROID
#include <jni.h>
#include <android/log.h>
#define LOGE(format,...) __android_log_print(ANDROID_LOG_ERROR,"",format,##__VA_ARGS__)
#define LOGI(format,...) __android_log_print(ANDROID_LOG_INFO,"",format,##__VA_ARGS__)


JNIEXPORT void JNICALL Java_com_fqcheng220_ffmpegdemo_MainActivity_stream
  (JNIEnv * env, jobject jobject, jstring input_jstr, jstring output_jstr){
  AVOutputFormat *ofmt = NULL;
  AVFormatContext *ifmt_ctx = NULL, *ofmt_ctx = NULL;

  int ret;
  	char input_str[500]={0};
  	char output_str[500]={0};
  	sprintf(input_str,"%s",(*env)->GetStringUTFChars(env,input_jstr, NULL));
  	sprintf(output_str,"%s",(*env)->GetStringUTFChars(env,output_jstr, NULL));

  av_register_all();
  	//Network
  	avformat_network_init();
  	//Input
    	if ((ret = avformat_open_input(&ifmt_ctx, input_str, 0, 0)) < 0) {
    		LOGE( "Could not open input file.");
    		goto end;
    	}
    	if ((ret = avformat_find_stream_info(ifmt_ctx, 0)) < 0) {
    		LOGE( "Failed to retrieve input stream information");
    		goto end;
    	}
    	end:
    	avformat_close_input(&ifmt_ctx);
        	/* close output */
        	if (ofmt_ctx && !(ofmt->flags & AVFMT_NOFILE))
        		avio_close(ofmt_ctx->pb);
        	avformat_free_context(ofmt_ctx);

  }
  #endif