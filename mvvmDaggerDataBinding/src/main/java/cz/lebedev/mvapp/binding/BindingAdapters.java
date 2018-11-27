package cz.lebedev.mvapp.binding;

import android.view.View;
import androidx.databinding.BindingAdapter;

public class BindingAdapters{
    @BindingAdapter("visibleGone")
    public static void setVisibility(View view, Boolean value) {
        view.setVisibility(value ? View.VISIBLE : View.GONE);
    }

}

