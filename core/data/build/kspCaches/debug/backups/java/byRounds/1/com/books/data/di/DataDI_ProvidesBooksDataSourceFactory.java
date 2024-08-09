package com.books.data.di;

import com.books.data.firebase.FirebaseHelper;
import com.books.data.source.BooksDataSource;
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
public final class DataDI_ProvidesBooksDataSourceFactory implements Factory<BooksDataSource> {
  private final Provider<FirebaseHelper> firebaseHelperProvider;

  public DataDI_ProvidesBooksDataSourceFactory(Provider<FirebaseHelper> firebaseHelperProvider) {
    this.firebaseHelperProvider = firebaseHelperProvider;
  }

  @Override
  public BooksDataSource get() {
    return providesBooksDataSource(firebaseHelperProvider.get());
  }

  public static DataDI_ProvidesBooksDataSourceFactory create(
      Provider<FirebaseHelper> firebaseHelperProvider) {
    return new DataDI_ProvidesBooksDataSourceFactory(firebaseHelperProvider);
  }

  public static BooksDataSource providesBooksDataSource(FirebaseHelper firebaseHelper) {
    return Preconditions.checkNotNullFromProvides(DataDI.INSTANCE.providesBooksDataSource(firebaseHelper));
  }
}
