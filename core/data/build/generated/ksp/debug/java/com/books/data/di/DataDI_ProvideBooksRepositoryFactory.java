package com.books.data.di;

import com.books.data.repository.BooksRepository;
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
public final class DataDi_ProvideBooksRepositoryFactory implements Factory<BooksRepository> {
  private final Provider<BooksDataSource> dataSourceProvider;

  public DataDi_ProvideBooksRepositoryFactory(Provider<BooksDataSource> dataSourceProvider) {
    this.dataSourceProvider = dataSourceProvider;
  }

  @Override
  public BooksRepository get() {
    return provideBooksRepository(dataSourceProvider.get());
  }

  public static DataDi_ProvideBooksRepositoryFactory create(
      Provider<BooksDataSource> dataSourceProvider) {
    return new DataDi_ProvideBooksRepositoryFactory(dataSourceProvider);
  }

  public static BooksRepository provideBooksRepository(BooksDataSource dataSource) {
    return Preconditions.checkNotNullFromProvides(DataDi.INSTANCE.provideBooksRepository(dataSource));
  }
}
