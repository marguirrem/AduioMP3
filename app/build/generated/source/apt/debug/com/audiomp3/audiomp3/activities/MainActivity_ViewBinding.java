// Generated code from Butter Knife. Do not modify!
package com.audiomp3.audiomp3.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.audiomp3.audiomp3.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131230750;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.txtUsuario = Utils.findRequiredViewAsType(source, R.id.txtUsuario, "field 'txtUsuario'", EditText.class);
    target.txtPassword = Utils.findRequiredViewAsType(source, R.id.txtPassword, "field 'txtPassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btnSigIn, "field 'btnIniciar' and method 'singIn'");
    target.btnIniciar = Utils.castView(view, R.id.btnSigIn, "field 'btnIniciar'", Button.class);
    view2131230750 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.singIn();
      }
    });
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progresBar, "field 'progressBar'", ContentLoadingProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtUsuario = null;
    target.txtPassword = null;
    target.btnIniciar = null;
    target.progressBar = null;

    view2131230750.setOnClickListener(null);
    view2131230750 = null;
  }
}
