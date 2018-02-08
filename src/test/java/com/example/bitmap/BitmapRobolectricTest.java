package com.example.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class BitmapRobolectricTest {
    private static final String TEST_PNG = "test.png";
    private static final String TEST_BMP = "test.bmp";

    @Test
    public void png_fromAssets_getPixel() throws IOException {
        InputStream resourceAsStream = RuntimeEnvironment.application.getAssets().open(TEST_PNG);
        Bitmap bitmap = BitmapFactory.decodeStream(resourceAsStream);
        assertThat(bitmap.getPixel(0, 0), equalTo(Color.argb(0xff, 0x80,0x80, 0x80)));
    }

    @Test
    public void png_fileDescriptor_fromAssets_getPixel() throws IOException {
        AssetFileDescriptor fd = RuntimeEnvironment.application.getAssets().openFd(TEST_PNG);
        Bitmap bitmap = BitmapFactory.decodeFileDescriptor(fd.getFileDescriptor());
        assertThat(bitmap.getPixel(0, 0), equalTo(Color.argb(0xff, 0x80,0x80, 0x80)));
    }

    @Test
    public void bmp_fromAssets_getPixel() throws IOException {
        InputStream resourceAsStream = RuntimeEnvironment.application.getAssets().open(TEST_BMP);
        Bitmap bitmap = BitmapFactory.decodeStream(resourceAsStream);
        assertThat(bitmap.getPixel(0, 0), equalTo(Color.argb(0xff, 0x80,0x80, 0x80)));
    }

    @Test
    public void bmp_fromResource_getPixel() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream(TEST_PNG);
        Bitmap bitmap = BitmapFactory.decodeStream(resourceAsStream);
        assertThat(bitmap.getPixel(0, 0), equalTo(Color.argb(0xff, 0x80,0x80, 0x80)));
    }
}
