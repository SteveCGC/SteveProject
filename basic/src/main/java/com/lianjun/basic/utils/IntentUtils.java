package com.lianjun.basic.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.lianjun.basic.R;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * author miekoz on 2016/3/15.
 * email  meikoz@126.com
 */
public class IntentUtils {

    public static boolean hasIntent(Intent intent) {
        return intent != null;
    }

    public static boolean hasExtra(Intent intent, String key) {
        return intent.hasExtra(key);
    }

    public static boolean getBooleanExtra(Intent intent, String name, boolean defaultValue) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return defaultValue;
        return intent.getBooleanExtra(name, defaultValue);
    }

    public static byte getByteExtra(Intent intent, String name, byte defaultValue) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return defaultValue;
        return intent.getByteExtra(name, defaultValue);
    }

    public static short getShortExtra(Intent intent, String name, short defaultValue) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return defaultValue;
        return intent.getShortExtra(name, defaultValue);
    }

    public static char getCharExtra(Intent intent, String name, char defaultValue) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return defaultValue;
        return intent.getCharExtra(name, defaultValue);
    }

    public static int getIntExtra(Intent intent, String name, int defaultValue) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return defaultValue;
        return intent.getIntExtra(name, defaultValue);
    }

    public long getLongExtra(Intent intent, String name, long defaultValue) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return defaultValue;
        return intent.getLongExtra(name, defaultValue);
    }

    public static float getFloatExtra(Intent intent, String name, float defaultValue) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return defaultValue;
        return intent.getFloatExtra(name, defaultValue);
    }

    public static double getDoubleExtra(Intent intent, String name, double defaultValue) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return defaultValue;
        return intent.getDoubleExtra(name, defaultValue);
    }

    public static String getStringExtra(Intent intent, String name) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return null;
        return intent.getStringExtra(name);
    }

    public static CharSequence getCharSequenceExtra(Intent intent, String name) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return null;
        return intent.getCharSequenceExtra(name);
    }

    public static <T extends Parcelable> T getParcelableExtra(Intent intent, String name) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return null;
        return intent.getParcelableExtra(name);
    }

    public static Parcelable[] getParcelableArrayExtra(Intent intent, String name) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return null;
        return intent.getParcelableArrayExtra(name);
    }

    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(Intent intent, String name) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return null;
        return intent.getParcelableArrayListExtra(name);
    }

    // ********** Serializable **********//

    public static Serializable getSerializableExtra(Intent intent, String name) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return null;
        return intent.getSerializableExtra(name);
    }

    public static ArrayList<Integer> getIntegerArrayListExtra(Intent intent, String name) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return null;
        return intent.getIntegerArrayListExtra(name);
    }

    public ArrayList<String> getStringArrayListExtra(Intent intent, String name) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return null;
        return intent.getStringArrayListExtra(name);
    }

    public static ArrayList<CharSequence> getCharSequenceArrayListExtra(Intent intent, String name) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return null;
        return intent.getCharSequenceArrayListExtra(name);
    }

    public static String[] getStringArrayExtra(Intent intent, String name) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return null;
        return intent.getStringArrayExtra(name);
    }

    // ********** Serializable **********//


    public static boolean[] getBooleanArrayExtra(Intent intent, String name) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return null;
        return intent.getBooleanArrayExtra(name);
    }

    public static byte[] getByteArrayExtra(Intent intent, String name) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return null;
        return intent.getByteArrayExtra(name);
    }

    public static short[] getShortArrayExtra(Intent intent, String name) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return null;
        return intent.getShortArrayExtra(name);
    }

    public static char[] getCharArrayExtra(Intent intent, String name) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return null;
        return intent.getCharArrayExtra(name);
    }

    public static int[] getIntArrayExtra(Intent intent, String name) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return null;
        return intent.getIntArrayExtra(name);
    }

    public static long[] getLongArrayExtra(Intent intent, String name) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return null;
        return intent.getLongArrayExtra(name);
    }

    public static float[] getFloatArrayExtra(Intent intent, String name) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return null;
        return intent.getFloatArrayExtra(name);
    }

    public static double[] getDoubleArrayExtra(Intent intent, String name) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return null;
        return intent.getDoubleArrayExtra(name);
    }

    public static CharSequence[] getCharSequenceArrayExtra(Intent intent, String name) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return null;
        return intent.getCharSequenceArrayExtra(name);
    }

    public static Bundle getBundleExtra(Intent intent, String name) {
        if (!hasIntent(intent) || !hasExtra(intent, name)) return null;
        return intent.getBundleExtra(name);
    }

    public static void startActivity(Activity context, Class clz){
        Intent intent = new Intent(context,clz);
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.flip_horizontal_in,
                R.anim.flip_horizontal_out);

    }

    public static void startActivity(Activity context, Intent intent){
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.flip_horizontal_in,
                R.anim.flip_horizontal_out);
    }

    public static void startActivityForResult(Activity context, Intent intent){
        context.startActivityForResult(intent,0);
        context.overridePendingTransition(R.anim.flip_horizontal_in,
                R.anim.flip_horizontal_out);
    }

    public static void startActivityForResult(Activity context, Intent intent,int requestCode){
        context.startActivityForResult(intent,requestCode);
        context.overridePendingTransition(R.anim.flip_horizontal_in,
                R.anim.flip_horizontal_out);
    }
}
