package com.arasof.aims.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "arasof_aims.db"
        private const val DATABASE_VERSION = 1

        // Table Names
        const val TABLE_CAMPUS_ASSET = "CampusAsset"
        const val TABLE_CAMPUS_BUILDING = "CampusBuilding"
        const val TABLE_FACILITY_ROOM = "FacilityRoom"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // Create CampusAsset Table
        val createAssetTable = ("CREATE TABLE " + TABLE_CAMPUS_ASSET + " ("
                + "property_no TEXT PRIMARY KEY, "
                + "item_name TEXT, "
                + "brand_model TEXT, "
                + "serial_no TEXT, "
                + "current_condition TEXT, "
                + "category_id TEXT, "
                + "room_id TEXT, "
                + "department_id TEXT, "
                + "date_acquired TEXT)")
        db?.execSQL(createAssetTable)

        // Create CampusBuilding Table
        val createBuildingTable = ("CREATE TABLE " + TABLE_CAMPUS_BUILDING + " ("
                + "building_id TEXT PRIMARY KEY, "
                + "building_name TEXT, "
                + "building_code TEXT, "
                + "total_floors INTEGER, "
                + "gis_id TEXT)")
        db?.execSQL(createBuildingTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_CAMPUS_ASSET")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_CAMPUS_BUILDING")
        onCreate(db)
    }
}