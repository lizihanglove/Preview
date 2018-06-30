package site.lizihanglove.example;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import site.lizihanglove.preview.Preview;

/**
 * @author lizihanglove
 */
public class MainActivity extends AppCompatActivity {
    private Preview preview;

    String imageUrl = "http://ww1.sinaimg.cn/large/0065oQSqly1fsq9iq8ttrj30k80q9wi4.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int color = getResources().getColor(R.color.color_gray);
        View previewView = getLayoutInflater().inflate(R.layout.preview_layout, null);
        ImageView previewImageView = previewView.findViewById(R.id.image_preview);
        Drawable drawable = getResources().getDrawable(R.drawable.preview);
        Glide.with(MainActivity.this)
                //.load(imageUrl)
                .load(drawable)
                .into(previewImageView);
        preview = new Preview.Builder(MainActivity.this)
                .setContentView(previewView)
                .setBackground(color)
                .build();
    }

    public void preview(View view) {
        preview.show();
    }
}
