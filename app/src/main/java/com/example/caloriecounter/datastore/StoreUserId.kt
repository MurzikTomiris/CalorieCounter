import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreUserId(private val dataStore: DataStore<Preferences>) {

    companion object {
        val USER_ID_KEY = intPreferencesKey("user_id")
    }

    val getId: Flow<Int?> = dataStore.data
        .map { preferences ->
            preferences[USER_ID_KEY]
        }

    suspend fun saveId(id: Int) {
        dataStore.edit { preferences ->
            preferences[USER_ID_KEY] = id
        }
    }
}