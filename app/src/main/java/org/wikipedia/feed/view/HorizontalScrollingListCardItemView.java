package org.wikipedia.feed.view;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import org.wikipedia.R;
import org.wikipedia.richtext.RichTextUtil;
import org.wikipedia.views.FaceAndColorDetectImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HorizontalScrollingListCardItemView extends CardView {
    @BindView(R.id.horizontal_scroll_list_item_image) FaceAndColorDetectImageView imageView;
    @BindView(R.id.horizontal_scroll_list_item_text) TextView textView;
    @Nullable private FeedAdapter.Callback callback;

    public HorizontalScrollingListCardItemView(@NonNull Context context) {
        super(context);
        inflate(getContext(), R.layout.view_horizontal_scroll_list_item_card, this);
        ButterKnife.bind(this);
        imageView.setLegacyVisibilityHandlingEnabled(true);
    }

    public void setCallback(@Nullable FeedAdapter.Callback callback) {
        this.callback = callback;
    }

    @Nullable
    public FeedAdapter.Callback getCallback() {
        return callback;
    }

    public void setText(@NonNull CharSequence text) {
        textView.setText(text);
        RichTextUtil.removeUnderlinesFromLinksAndMakeBold(textView);
    }

    public void setImage(@Nullable Uri image) {
        imageView.loadImage(image);
    }

    public View getImageView() {
        return imageView;
    }
}
