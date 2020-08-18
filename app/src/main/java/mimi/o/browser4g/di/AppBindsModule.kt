package mimi.o.browser4g.di

import mimi.o.browser4g.adblock.allowlist.AllowListModel
import mimi.o.browser4g.adblock.allowlist.SessionAllowListModel
import mimi.o.browser4g.database.allowlist.AdBlockAllowListDatabase
import mimi.o.browser4g.database.allowlist.AdBlockAllowListRepository
import mimi.o.browser4g.database.bookmark.BookmarkDatabase
import mimi.o.browser4g.database.bookmark.BookmarkRepository
import mimi.o.browser4g.database.downloads.DownloadsDatabase
import mimi.o.browser4g.database.downloads.DownloadsRepository
import mimi.o.browser4g.database.feeds.FeedsDatabase
import mimi.o.browser4g.database.feeds.FeedsRepository
import mimi.o.browser4g.database.history.HistoryDatabase
import mimi.o.browser4g.database.history.HistoryRepository
import mimi.o.browser4g.ssl.SessionSslWarningPreferences
import mimi.o.browser4g.ssl.SslWarningPreferences
import dagger.Binds
import dagger.Module

/**
 * Dependency injection module used to bind implementations to interfaces.
 */
@Module
abstract class AppBindsModule {

    @Binds
    abstract fun provideBookmarkModel(bookmarkDatabase: BookmarkDatabase): BookmarkRepository

    @Binds
    abstract fun provideDownloadsModel(downloadsDatabase: DownloadsDatabase): DownloadsRepository

    @Binds
    abstract fun providesHistoryModel(historyDatabase: HistoryDatabase): HistoryRepository

    @Binds
    abstract fun providesAdBlockAllowListModel(adBlockAllowListDatabase: AdBlockAllowListDatabase): AdBlockAllowListRepository

    @Binds
    abstract fun providesAllowListModel(sessionAllowListModel: SessionAllowListModel): AllowListModel

    @Binds
    abstract fun providesFeedsModel(feedsDatabase: FeedsDatabase): FeedsRepository

    @Binds
    abstract fun providesSslWarningPreferences(sessionSslWarningPreferences: SessionSslWarningPreferences): SslWarningPreferences

}
