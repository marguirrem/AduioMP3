// Generated code from Butter Knife. Do not modify!
package com.audiomp3.audiomp3.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.audiomp3.audiomp3.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view2131230749;

  private View view2131230898;

  private View view2131230899;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    target.etUsuario = Utils.findRequiredViewAsType(source, R.id.loginEtUsuario, "field 'etUsuario'", EditText.class);
    target.etPassword = Utils.findRequiredViewAsType(source, R.id.loginEtPassword, "field 'etPassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btnSigIn, "field 'btnIniciar' and method 'singIn'");
    target.btnIniciar = Utils.castView(view, R.id.btnSigIn, "field 'btnIniciar'", Button.class);
    view2131230749 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.singIn();
      }
    });
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.loginProgress, "field 'progressBar'", ProgressBar.class);
    view = Utils.findRequiredView(source, R.id.tvMessagePassword, "field 'tvMessagePassword' and method 'recoverPassword'");
    target.tvMessagePassword = Utils.castView(view, R.id.tvMessagePassword, "field 'tvMessagePassword'", TextView.class);
    view2131230898 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.recoverPassword();
      }
    });
    view = Utils.findRequiredView(source, R.id.tvMessageSignUp, "field 'tvMessageSignUp' and method 'singUp'");
    target.tvMessageSignUp = Utils.castView(view, R.id.tvMessageSignUp, "field 'tvMessageSignUp'", TextView.class);
    view2131230899 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.singUp();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etUsuario = null;
    target.etPassword = null;
    target.btnIniciar = null;
    target.progressBar = null;
    target.tvMessagePassword = null;
    target.tvMessageSignUp = null;

    view2131230749.setOnClickListener(null);
    view2131230749 = null;
    view2131230898.setOnClickListener(null);
    view2131230898 = null;
    view2131230899.setOnClickListener(null);
    view2131230899 = null;
  }
}
