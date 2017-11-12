package uk.ac.uclan.tmckeown2.travelguide.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;

import uk.ac.uclan.tmckeown2.travelguide.R;

public class CardListAdapter extends ArrayAdapter<Card> {
    private static final String TAG = "CardListAdapter";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    private static class ViewHolder {
        TextView title;
        ImageView image;
    }

    public CardListAdapter(Context context, int res, ArrayList<Card> cards) {
        super(context, res, cards);
        mContext = context;
        mResource = res;

        setupImageLoader();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String title = getItem(position).getCardTitle();
        String imgURL = getItem(position).getImgURL();

        try {
            final View result;

            ViewHolder holder;

            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(mResource, parent, false);
                holder = new ViewHolder();
                holder.title = (TextView) convertView.findViewById(R.id.cardTitle);
                holder.image = (ImageView) convertView.findViewById(R.id.cardImage);

                result = convertView;

                convertView.setTag(holder);
            }
            else {
                holder = (ViewHolder) convertView.getTag();
                result = convertView;
            }

            lastPosition = position;

            holder.title.setText(title);

            ImageLoader imgLoader = ImageLoader.getInstance();

            int defaultImage = mContext.getResources().getIdentifier("@drawable/ic_default_image", null, mContext.getPackageName());

            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)
                    .cacheOnDisk(true).resetViewBeforeLoading(true)
                    .showImageForEmptyUri(defaultImage)
                    .showImageOnLoading(defaultImage).build();

            imgLoader.displayImage(imgURL, holder.image, options);

            return convertView;
        }
        catch (IllegalArgumentException ex) {
            Log.e(TAG, "getView: IllegalArgumentException: " + ex.getMessage());
            return convertView;
        }
    }

    private void setupImageLoader() {
        Log.d(TAG, "setupImageLoader: Setting up universal image loader");

        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisk(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(mContext)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache()).build();

        ImageLoader.getInstance().init(config);
    }
}
