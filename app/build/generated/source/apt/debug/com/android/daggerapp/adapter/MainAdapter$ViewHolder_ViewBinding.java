// Generated code from Butter Knife. Do not modify!
package com.android.daggerapp.adapter;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.android.daggerapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public final class MainAdapter$ViewHolder_ViewBinding implements Unbinder {
  private MainAdapter.ViewHolder target;

  @UiThread
  public MainAdapter$ViewHolder_ViewBinding(MainAdapter.ViewHolder target, View source) {
    this.target = target;

    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", TextView.class);
  }

  @Override
  public void unbind() {
    MainAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.title = null;
  }
}
