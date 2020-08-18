package mimi.o.browser4g.database.feeds

import mimi.o.browser4g.database.FeedsModel

interface FeedsRepository {

    fun clearFeeds()
    fun feedEntry(item: FeedsModel)
    fun allEntries(): List<FeedsModel>

}