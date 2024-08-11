package com.books.data.di;

import com.books.data.source.BooksDataSource;
import com.books.firebase.FirebaseHelper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class DataDi_ProvidesBooksDataSourceFactory implements Factory<BooksDataSource> {
  private final Provider<FirebaseHelper> firebaseHelperProvider;

  public DataDi_ProvidesBooksDataSourceFactory(Provider<FirebaseHelper> firebaseHelperProvider) {
    this.firebaseHelperProvider = firebaseHelperProvider;
  }

  @Override
  public BooksDataSource get() {
    return providesBooksDataSource(firebaseHelperProvider.get());
  }

  public static DataDi_ProvidesBooksDataSourceFactory create(
      Provider<FirebaseHelper> firebaseHelperProvider) {
    return new DataDi_ProvidesBooksDataSourceFactory(firebaseHelperProvider);
  }

  public static BooksDataSource providesBooksDataSource(FirebaseHelper firebaseHelper) {
    return Preconditions.checkNotNullFromProvides(DataDi.INSTANCE.providesBooksDataSource(firebaseHelper));
  }
}
