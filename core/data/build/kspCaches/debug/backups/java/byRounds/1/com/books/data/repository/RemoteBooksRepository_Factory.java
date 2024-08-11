package com.books.data.repository;

import com.books.data.source.BooksDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

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

  private final Provider<CoroutineDispatcher> ioDispatcherProvider;

  public RemoteBooksRepository_Factory(Provider<BooksDataSource> dataSourceProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    this.dataSourceProvider = dataSourceProvider;
    this.ioDispatcherProvider = ioDispatcherProvider;
  }

  @Override
  public RemoteBooksRepository get() {
    return newInstance(dataSourceProvider.get(), ioDispatcherProvider.get());
  }

  public static RemoteBooksRepository_Factory create(Provider<BooksDataSource> dataSourceProvider,
      Provider<CoroutineDispatcher> ioDispatcherProvider) {
    return new RemoteBooksRepository_Factory(dataSourceProvider, ioDispatcherProvider);
  }

  public static RemoteBooksRepository newInstance(BooksDataSource dataSource,
      CoroutineDispatcher ioDispatcher) {
    return new RemoteBooksRepository(dataSource, ioDispatcher);
  }
}
