package com.mikkipastel.fangjaimockup.View;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View.BaseSavedState;

/**
 * Created by acer on 4/21/2017.
 */

public class BundleSavedState extends BaseSavedState {
    private Bundle bundle = new Bundle();

    public BundleSavedState(Parcel source) {
        super(source);
        bundle = source.readBundle();
    }

    public BundleSavedState(Parcelable superState) {
        super(superState);
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeBundle(bundle);
    }

    public Bundle getBundle() {
        return bundle;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public Object createFromParcel(Parcel source) {
            return new BundleSavedState(source);
        }

        @Override
        public Object[] newArray(int size) {
            return new BundleSavedState[size];
        }
    };
}
