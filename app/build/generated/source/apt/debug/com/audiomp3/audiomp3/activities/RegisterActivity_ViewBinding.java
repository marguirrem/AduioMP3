// Generated code from Butter Knife. Do not modify!
package com.audiomp3.audiomp3.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.audiomp3.audiomp3.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegisterActivity_ViewBinding implements Unbinder {
  private RegisterActivity target;

  private View view2131230750;

  @UiThread
  public RegisterActivity_ViewBinding(RegisterActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RegisterActivity_ViewBinding(final RegisterActivity target, View source) {
    this.target = target;

    View view;
    target.etFirstName = Utils.findRequiredViewAsType(source, R.id.etFirstName, "field 'etFirstName'", EditText.class);
    target.etLastName = Utils.findRequiredViewAsType(source, R.id.etLastName, "field 'etLastName'", EditText.class);
    target.etEmail = Utils.findRequiredViewAsType(source, R.id.etEmail, "field 'etEmail'", EditText.class);
    target.etPassword = Utils.findRequiredViewAsType(source, R.id.etPassword, "field 'etPassword'", EditText.class);
    target.etConfirmPassword = Utils.findRequiredViewAsType(source, R.id.etConfirmPassword, "field 'etConfirmPassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btnSignUp, "field 'btnSignUp' and method 'signUp'");
    target.btnSignUp = Utils.castView(view, R.id.btnSignUp, "field 'btnSignUp'", Button.class);
    view2131230750 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.signUp();
      }
    });
    target.registerProgress = Utils.findRequiredViewAsType(source, R.id.registerProgress, "field 'registerProgress'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RegisterActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etFirstName = null;
    target.etLastName = null;
    target.etEmail = null;
    target.etPassword = null;
    target.etConfirmPassword = null;
    target.btnSignUp = null;
    target.registerProgress = null;

    view2131230750.setOnClickListener(null);
    view2131230750 = null;
  }
}
