package com.books.data.di;

import android.content.Context;
import com.books.data.network.NetworkMonitor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class DataDi_ProvidesNetworkMonitorFactory implements Factory<NetworkMonitor> {
  private final Provider<Context> contextProvider;

  public DataDi_ProvidesNetworkMonitorFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NetworkMonitor get() {
    return providesNetworkMonitor(contextProvider.get());
  }

  public static DataDi_ProvidesNetworkMonitorFactory create(Provider<Context> contextProvider) {
    return new DataDi_ProvidesNetworkMonitorFactory(contextProvider);
  }

  public static NetworkMonitor providesNetworkMonitor(Context context) {
    return Preconditions.checkNotNullFromProvides(DataDi.INSTANCE.providesNetworkMonitor(context));
  }
}
