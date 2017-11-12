package uk.ac.uclan.tmckeown2.travelguide.utils;

public class Card {
    private String mImgURL;
    private String mCardTitle;

    public Card(String imgURL, String title) {
        mImgURL = imgURL;
        mCardTitle = title;
    }

    public String getImgURL() {
        return mImgURL;
    }

    public void setImgURL(String imgURL) {
        mImgURL = imgURL;
    }

    public String getCardTitle() {
        return mCardTitle;
    }

    public void setTitle(String title) {
        mCardTitle = title;
    }
}
