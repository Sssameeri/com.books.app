package com.books.common.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import kotlinx.serialization.json.Json;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
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
public final class JsonDi_ProvidesJsonFactory implements Factory<Json> {
  @Override
  public Json get() {
    return providesJson();
  }

  public static JsonDi_ProvidesJsonFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Json providesJson() {
    return Preconditions.checkNotNullFromProvides(JsonDi.INSTANCE.providesJson());
  }

  private static final class InstanceHolder {
    private static final JsonDi_ProvidesJsonFactory INSTANCE = new JsonDi_ProvidesJsonFactory();
  }
}
