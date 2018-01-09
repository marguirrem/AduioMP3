// Generated code from Butter Knife. Do not modify!
package com.audiomp3.audiomp3.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.audiomp3.audiomp3.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainScreenActivity_ViewBinding implements Unbinder {
  private MainScreenActivity target;

  private View view2131230748;

  private View view2131230749;

  @UiThread
  public MainScreenActivity_ViewBinding(MainScreenActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainScreenActivity_ViewBinding(final MainScreenActivity target, View source) {
    this.target = target;

    View view;
    target.imageLogo = Utils.findRequiredViewAsType(source, R.id.imageLogo, "field 'imageLogo'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.btnInicio, "field 'Inicio' and method 'iniciar'");
    target.Inicio = Utils.castView(view, R.id.btnInicio, "field 'Inicio'", Button.class);
    view2131230748 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.iniciar();
      }
    });
    view = Utils.findRequiredView(source, R.id.btnRegistro, "field 'Registro' and method 'crear'");
    target.Registro = Utils.castView(view, R.id.btnRegistro, "field 'Registro'", Button.class);
    view2131230749 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.crear();
      }
    });
    target.layoutImage = Utils.findRequiredViewAsType(source, R.id.layoutImage, "field 'layoutImage'", LinearLayout.class);
    target.buttons = Utils.findRequiredViewAsType(source, R.id.buttons, "field 'buttons'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainScreenActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imageLogo = null;
    target.Inicio = null;
    target.Registro = null;
    target.layoutImage = null;
    target.buttons = null;

    view2131230748.setOnClickListener(null);
    view2131230748 = null;
    view2131230749.setOnClickListener(null);
    view2131230749 = null;
  }
}
