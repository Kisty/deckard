package com.example.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class BitmapAndroidTest {
    private static final String TEST_PNG = "test.png";
    private static final String TEST_BMP = "test.bmp";

    @Test
    public void png_fromAssets_getPixel() throws IOException {
        InputStream resourceAsStream = InstrumentationRegistry.getContext().getAssets().open(TEST_PNG);
        Bitmap bitmap = BitmapFactory.decodeStream(resourceAsStream);
        assertThat(bitmap.getPixel(0, 0), equalTo(Color.argb(0xff, 0x80,0x80, 0x80)));
    }

    @Test
    public void bmp_fromAssets_getPixel() throws IOException {
        InputStream resourceAsStream = InstrumentationRegistry.getContext().getAssets().open(TEST_BMP);
        Bitmap bitmap = BitmapFactory.decodeStream(resourceAsStream);
        assertThat(bitmap.getPixel(0, 0), equalTo(Color.argb(0xff, 0x80,0x80, 0x80)));
    }
}
