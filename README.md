# Preview  ![GitHub (pre-)release](https://img.shields.io/badge/release-1.0.0-brightgreen.svg)

### Preview is dialog for show image or other full screen layout.

# Preview
<img src="https://github.com/lizihanglove/Preview/blob/master/art/preview.gif" width="200" hegiht="500" align=center />

# Usage 

#### Step 1. Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

#### Step 2. Add the dependency
```
	dependencies {
		implementation 'com.github.lizihanglove:Preview:1.0.0'
	}
```

#### Step 3. Build a dialog

##### a.Java
###### a.a create layout 
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ImageView
        android:id="@+id/image_preview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:contentDescription="@string/dialog"
        android:scaleType="fitCenter"/>
</LinearLayout>
```

###### a.b code your java
```
	String imageUrl = "http://ww1.sinaimg.cn/large/0065oQSqly1fsq9iq8ttrj30k80q9wi4.jpg";
	Drawable drawable = getResources().getDrawable(R.drawable.preview);
        Glide.with(MainActivity.this)
                //.load(imageUrl)
                .load(drawable)
                .into(previewImageView);
        preview = new Preview.Builder(MainActivity.this)
                .setContentView(previewView)
                .setBackground(color)
                .build();
```

##### b.Kotlin
###### b.a create your layout
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ImageView
        android:id="@+id/image_preview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:contentDescription="@string/dialog"
        android:scaleType="fitCenter"/>
</LinearLayout>
```
###### b.b code your kotlin
```
	val view = mContext.layoutInflater.inflate(R.layout.preview_layout, null)
	val imagePreview = view.find<ImageView>(R.id.image_preview)
	GlideApp.with(mContext)
		.load(imagesUrl)
		.placeholder(R.drawable.empty)
		.into(imagePreview)
	Preview.Builder(mContext)
		.setBackground(color)
		.setContentView(view)
		.build()
		.show()
```

# License [![GitHub license](https://img.shields.io/github/license/lizihanglove/Preview.svg)](https://github.com/lizihanglove/Preview/blob/master/LICENSE)
