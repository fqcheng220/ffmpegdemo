LOCAL_PATH := $(call my-dir)

# Program
include $(CLEAR_VARS)
LOCAL_MODULE := testJni
LOCAL_SRC_FILES :=com_fqcheng220_ffmpegdemo_TestActivity.c
LOCAL_LDLIBS := -llog -lz
include $(BUILD_SHARED_LIBRARY)