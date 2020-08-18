package mimi.o.browser4g.di

import mimi.o.browser4g.BrowserApp
import mimi.o.browser4g.adblock.AssetsAdBlocker
import mimi.o.browser4g.adblock.NoOpAdBlocker
import mimi.o.browser4g.browser.SearchBoxModel
import mimi.o.browser4g.browser.activity.BrowserActivity
import mimi.o.browser4g.browser.activity.ThemableBrowserActivity
import mimi.o.browser4g.browser.fragment.BookmarksFragment
import mimi.o.browser4g.browser.fragment.TabsFragment
import mimi.o.browser4g.dialog.LightningDialogBuilder
import mimi.o.browser4g.download.DownloadHandler
import mimi.o.browser4g.download.LightningDownloadListener
import mimi.o.browser4g.reading.activity.ReadingActivity
import mimi.o.browser4g.search.SuggestionsAdapter
import mimi.o.browser4g.settings.activity.SettingsActivity
import mimi.o.browser4g.settings.activity.ThemableSettingsActivity
import mimi.o.browser4g.settings.fragment.*
import mimi.o.browser4g.utils.ProxyUtils
import mimi.o.browser4g.view.LightningChromeClient
import mimi.o.browser4g.view.LightningView
import mimi.o.browser4g.view.LightningWebClient
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (AppBindsModule::class)])
interface AppComponent {

    fun inject(activity: BrowserActivity)

    fun inject(fragment: BookmarksFragment)

    fun inject(fragment: BookmarkSettingsFragment)

    fun inject(builder: LightningDialogBuilder)

    fun inject(fragment: TabsFragment)

    fun inject(lightningView: LightningView)

    fun inject(activity: ThemableBrowserActivity)

    fun inject(advancedSettingsFragment: AdvancedSettingsFragment)

    fun inject(app: BrowserApp)

    fun inject(proxyUtils: ProxyUtils)

    fun inject(activity: ReadingActivity)

    fun inject(webClient: LightningWebClient)

    fun inject(activity: SettingsActivity)

    fun inject(activity: ThemableSettingsActivity)

    fun inject(listener: LightningDownloadListener)

    fun inject(fragment: PrivacySettingsFragment)

    fun inject(fragment: DebugSettingsFragment)

    fun inject(suggestionsAdapter: SuggestionsAdapter)

    fun inject(chromeClient: LightningChromeClient)

    fun inject(downloadHandler: DownloadHandler)

    fun inject(searchBoxModel: SearchBoxModel)

    fun inject(generalSettingsFragment: GeneralSettingsFragment)

    fun inject(displaySettingsFragment: DisplaySettingsFragment)

    fun provideAssetsAdBlocker(): AssetsAdBlocker

    fun provideNoOpAdBlocker(): NoOpAdBlocker

}
