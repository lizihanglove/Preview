package site.lizihanglove.preview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.Window;


/**
 * @author lizihanglove
 * @email one_mighty@163.com
 * @date 2018-06-27
 * @time 23:36
 * @desc Fullscreen Dialog for image
 */
public class Preview extends Dialog {
    /**
     * Constructor For Preview
     *
     * @param context Context
     */
    private Preview(@NonNull Context context) {
        this(context, R.style.Preview_Dialog);
    }

    /**
     * Constructor For Preview
     *
     * @param context    Context
     * @param themeResId Theme
     */
    private Preview(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }


    /**
     * dismiss this dialog when touch
     *
     * @param event MotionEvent
     * @return is consume this event
     */
    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                this.dismiss();
                return true;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }


    /**
     * show this dialog
     */
    @Override
    public void show() {
        super.show();
    }

    /**
     * dismiss this dialog
     */
    @Override
    public void dismiss() {
        super.dismiss();
    }

    /**
     * Builder for Preview
     */
    public static class Builder {
        private Preview preview;
        private Context mContext;
        private int mColor = 0x666666;

        /**
         * Constructor for Builder
         *
         * @param context Context
         */
        public Builder(Context context) {
            this.mContext = context;
            preview = new Preview(mContext);
        }

        /**
         * set content view for Preview
         *
         * @param layoutResID Layout
         * @return Builder
         */
        public Builder setContentView(@LayoutRes int layoutResID) {
            this.preview.setContentView(layoutResID);
            return this;
        }

        /**
         * set content view for Preview
         *
         * @param view View
         * @return Builder
         */
        public Builder setContentView(@NonNull View view) {
            this.preview.setContentView(view);
            return this;
        }

        public Builder setBackground(@ColorInt int colorResId) {
            this.mColor = colorResId;
            return this;
        }

        /**
         * return an Instance of Preview
         *
         * @return Preview
         */
        public Preview build() {
            ColorDrawable colorDrawable = new ColorDrawable(mColor);
            Window window = preview.getWindow();
            if (null != window) {
                window.setBackgroundDrawable(colorDrawable);
            }
            return preview;
        }
    }
}
