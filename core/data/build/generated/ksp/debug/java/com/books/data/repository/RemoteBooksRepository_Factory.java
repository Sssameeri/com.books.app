package com.books.data.repository;

import com.books.data.source.BooksDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class RemoteBooksRepository_Factory implements Factory<RemoteBooksRepository> {
  private final Provider<BooksDataSource> dataSourceProvider;

  public RemoteBooksRepository_Factory(Provider<BooksDataSource> dataSourceProvider) {
    this.dataSourceProvider = dataSourceProvider;
  }

  @Override
  public RemoteBooksRepository get() {
    return newInstance(dataSourceProvider.get());
  }

  public static RemoteBooksRepository_Factory create(Provider<BooksDataSource> dataSourceProvider) {
    return new RemoteBooksRepository_Factory(dataSourceProvider);
  }

  public static RemoteBooksRepository newInstance(BooksDataSource dataSource) {
    return new RemoteBooksRepository(dataSource);
  }
}
