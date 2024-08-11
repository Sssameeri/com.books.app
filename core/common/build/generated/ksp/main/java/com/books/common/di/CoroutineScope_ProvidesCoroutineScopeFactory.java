package com.books.common.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("com.books.common.di.ApplicationScope")
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
public final class CoroutineScope_ProvidesCoroutineScopeFactory implements Factory<kotlinx.coroutines.CoroutineScope> {
  @Override
  public kotlinx.coroutines.CoroutineScope get() {
    return providesCoroutineScope();
  }

  public static CoroutineScope_ProvidesCoroutineScopeFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static kotlinx.coroutines.CoroutineScope providesCoroutineScope() {
    return Preconditions.checkNotNullFromProvides(CoroutineScope.INSTANCE.providesCoroutineScope());
  }

  private static final class InstanceHolder {
    private static final CoroutineScope_ProvidesCoroutineScopeFactory INSTANCE = new CoroutineScope_ProvidesCoroutineScopeFactory();
  }
}
