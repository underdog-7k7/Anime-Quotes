package com.personal.animeshpandey.animefacts.ViewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personal.animeshpandey.animefacts.Model.Quote
import com.personal.animeshpandey.animefacts.Model.QuoteService
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    init{
        fetchQuotes()
    }

    data class currentstate(
        val loading:Boolean = true,
        val recieved_quote: Quote = Quote(0,"Default Quote","Some anime", "Some character"),
        val error: String? = null
    )


    private val _quotestate = mutableStateOf(currentstate())
    val publicquotestate: State<currentstate> = _quotestate

    fun fetchQuotes(){
        viewModelScope.launch {
            //if internet fails
            try{
                val response = QuoteService.getQuotes()

                Log.d("RESPONSE_OBTAINED",response.quote)

                _quotestate.value = _quotestate.value.copy(
                    recieved_quote = response,
                    loading = false,
                    error = null
                )
            }catch (e:Exception){
                _quotestate.value = _quotestate.value.copy(
                    loading = false, error = "Error fetching the quote"
                )
            }
        }
    }

}