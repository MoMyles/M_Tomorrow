package cc.momyles.tomorrow.loader;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.AppCompatImageView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.youth.banner.loader.ImageLoader;

import java.io.File;

import cc.momyles.tomorrow.R;

public class ImgLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        if (path instanceof String) {
            Picasso.get().load((String) path).placeholder(R.mipmap.img_default).fit().into(imageView);
        } else if (path instanceof File) {
            Picasso.get().load((File) path).placeholder(R.mipmap.img_default).fit().into(imageView);
        } else if (path instanceof Integer) {
            Picasso.get().load((Integer) path).placeholder(R.mipmap.img_default).fit().into(imageView);
        } else if (path instanceof Uri) {
            Picasso.get().load((Uri) path).placeholder(R.mipmap.img_default).fit().into(imageView);
        }
    }

    @Override
    public ImageView createImageView(Context context) {
        final AppCompatImageView aiv = new AppCompatImageView(context);
        aiv.setScaleType(ImageView.ScaleType.FIT_XY);
        aiv.setAdjustViewBounds(true);
        return aiv;
    }
}
