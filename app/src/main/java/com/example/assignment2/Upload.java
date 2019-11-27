package com.example.assignment2;

public class Upload {
    private String mName;
    private String mImageUri;
    private String mDesc;

    public Upload()
    {

    }
    public Upload(String mName, String mImageUri,String mDesc) {

        if (mName.trim().equals(""))
        {
            mName="No Name";
        }
        this.mName = mName;
        this.mImageUri = mImageUri;
        this.mDesc=mDesc;
    }



    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmImageUri() {
        return mImageUri;
    }

    public void setmImageUri(String mImageUri) {
        this.mImageUri = mImageUri;
    }

    public String getmDesc() {
        return mDesc;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }
}
