package mimi.o.browser4g.search.suggestions

import mimi.o.browser4g.database.SearchSuggestion
import io.reactivex.Single

/**
 * A search suggestions repository that doesn't fetch any results.
 */
class NoOpSuggestionsRepository : SuggestionsRepository {

    private val emptySingle: Single<List<SearchSuggestion>> = Single.just(emptyList())

    override fun resultsForSearch(rawQuery: String) = emptySingle
}
