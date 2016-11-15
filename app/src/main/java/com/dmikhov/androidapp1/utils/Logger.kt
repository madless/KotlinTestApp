package com.dmikhov.androidapp1.utils

import android.util.Log
import java.io.PrintWriter
import java.io.StringWriter
import java.util.*

class Logger {

    private val FILTER_BODY_NAME = "<body>"
    private val FILTER_MSG_NAME = " <msg> "
    private val TAG_NAME = "KOTLIN_APP"
    private val CHUNK_FORMAT = "CHUNK %d OF %d:  %s"
    private val CONSOLE_LOG_LINE_LENGTH = 4000
    var isEnabled = true

    private var cls: Class<*>? = null

    private constructor() {}

    constructor(cls: Class<*>) {
        this.cls = cls
    }

    private constructor(cls: Class<*>, isEnabled: Boolean) {
        this.cls = cls
        this.isEnabled = isEnabled
    }

    /**********************************************************************************************
     * DEBUG
     */
    fun debug(message: String) {
        d(message)
    }

    fun d(message: String) {
        if (isEnabled) {
            debug(cls, message)
        }
    }


    /**********************************************************************************************
     * INFO
     */

    fun i(message: String) {
        if (isEnabled) {
            info(cls, message)
        }
    }


    /**********************************************************************************************
     * WARN
     */
    fun warn(message: String) {
        if (isEnabled) {
            warn(cls, message)
        }
    }

    fun w(msg: String) {
        warn(msg)
    }


    /**********************************************************************************************
     * ERROR
     */
    fun error(message: String, e: Exception) {
        error(cls, message, e)
    }

    fun e(msg: String) {
        error(msg)
    }

    fun error(message: String) {
        if (isEnabled) {
            error(cls, message)
        }
    }

    public fun getLogger(cls: Class<*>): Logger {
        return Logger(cls)
    }

    fun getLogger(cls: Class<*>, isEnabled: Boolean): Logger {
        return Logger(cls, isEnabled)
    }

    fun debug(cls: Class<*>?, message: String) {
        val text = cls?.simpleName + FILTER_MSG_NAME + message
        print(Log.DEBUG, text)
    }

    fun info(cls: Class<*>?, message: String) {
        val text = cls?.simpleName + FILTER_MSG_NAME + message
        infoOutput(text)
    }

    private fun infoOutput(message: String) {
        print(Log.INFO, message)
    }

    fun warn(cls: Class<*>?, message: String) {
        val text = cls?.simpleName + FILTER_MSG_NAME + message
        warnOutput(text)
    }

    private fun warnOutput(message: String) {
        print(Log.WARN, message)
    }

    fun error(cls: Class<*>?, message: String, e: Exception) {
        val sw = StringWriter()
        val pw = PrintWriter(sw)
        e.printStackTrace(pw)
        val text = cls?.simpleName + FILTER_MSG_NAME + message + "\n" + sw.toString()
        errorOutput(text)
    }

    fun error(cls: Class<*>?, message: String) {
        val text = cls?.simpleName + FILTER_MSG_NAME + message
        errorOutput(text)
    }

    private fun errorOutput(message: String) {
        print(Log.ERROR, message)
    }

    private fun print(priority: Int, message: String) {
        val fullMsg = FILTER_BODY_NAME + message
        if (fullMsg.length > CONSOLE_LOG_LINE_LENGTH) {
            val chunkCount = fullMsg.length / CONSOLE_LOG_LINE_LENGTH     // integer division
            for (i in 0..chunkCount) {
                val max = CONSOLE_LOG_LINE_LENGTH * (i + 1)
                val textToPrint: String
                if (max >= fullMsg.length) {
                    textToPrint = String.format(Locale.ENGLISH, CHUNK_FORMAT, i, chunkCount, fullMsg.substring(CONSOLE_LOG_LINE_LENGTH * i))
                } else {
                    textToPrint = String.format(Locale.ENGLISH, CHUNK_FORMAT, i, chunkCount, fullMsg.substring(CONSOLE_LOG_LINE_LENGTH * i, max))
                }
                Log.println(priority, TAG_NAME, textToPrint)
            }
        } else {
            Log.println(priority, TAG_NAME, FILTER_BODY_NAME + message)
        }
    }
}