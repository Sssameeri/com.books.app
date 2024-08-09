package com.books.data.firebase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class FirebaseDi_ProvidesFirebaseHelperFactory implements Factory<FirebaseHelper> {
  @Override
  public FirebaseHelper get() {
    return providesFirebaseHelper();
  }

  public static FirebaseDi_ProvidesFirebaseHelperFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FirebaseHelper providesFirebaseHelper() {
    return Preconditions.checkNotNullFromProvides(FirebaseDi.INSTANCE.providesFirebaseHelper());
  }

  private static final class InstanceHolder {
    private static final FirebaseDi_ProvidesFirebaseHelperFactory INSTANCE = new FirebaseDi_ProvidesFirebaseHelperFactory();
  }
}
