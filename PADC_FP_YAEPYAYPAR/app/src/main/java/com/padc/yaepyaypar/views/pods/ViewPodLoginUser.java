package com.padc.yaepyaypar.views.pods;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.padc.yaepyaypar.R;
import com.padc.yaepyaypar.controllers.BaseController;
import com.padc.yaepyaypar.controllers.UserController;
import com.padc.yaepyaypar.controllers.ViewController;
import com.padc.yaepyaypar.data.vos.UserVO;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mkt on 9/14/2016.
 */
public class ViewPodLoginUser extends RelativeLayout implements ViewController {

    @BindView(R.id.iv_profile_cover)
    ImageView ivProfileCover;

    @BindView(R.id.iv_profile)
    ImageView ivProfile;

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_email)
    TextView tvEmail;

    private UserController mController;

    public ViewPodLoginUser(Context context) {
        super(context);
    }

    public ViewPodLoginUser(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewPodLoginUser(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }


    @Override
    public void setController(BaseController controller) {
        mController = (UserController) controller;
    }

    public void setData(UserVO loginUser) {
        Glide.with(getContext())
                .load(loginUser.getCoverPicture())
                .centerCrop()
                .placeholder(R.drawable.drawer_background)
                .error(R.drawable.drawer_background)
                .into(ivProfileCover);

        Glide.with(getContext())
                .load(loginUser.getProfilePicture())
                .asBitmap().centerCrop()
                .placeholder(R.drawable.dummy_avatar)
                .error(R.drawable.dummy_avatar)
                .into(new BitmapImageViewTarget(ivProfile) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(ivProfile.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        ivProfile.setImageDrawable(circularBitmapDrawable);
                    }
                });

        tvName.setText(loginUser.getName());
        tvEmail.setText(loginUser.getEmail());
    }

    @OnClick(R.id.btn_logout)
    public void onTapLogout(Button btnLogout) {
        mController.onTapLogout();
    }
}
