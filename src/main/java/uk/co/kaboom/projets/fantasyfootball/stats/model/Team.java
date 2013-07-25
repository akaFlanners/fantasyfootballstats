package uk.co.kaboom.projets.fantasyfootball.stats.model;

public enum Team {
     ARSENAL    ("te_1"  ,"Arsenal"    ),
     ASTON_VILLA("te_2"  ,"Aston Villa"),
     CHELSEA    ("te_3"  ,"Chelsea"    ),
     EVERTON    ("te_4"  ,"Everton"    ),
     FULHAM     ("te_5"  ,"Fulham"     ),
     LIVERPOOL  ("te_6"  ,"Liverpool"  ),
     MAN_CITY   ("te_7"  ,"Man City"   ),
     MAN_UTD    ("te_8"  ,"Man Utd"    ),
     NEWCASTLE  ("te_9"  ,"Newcastle"  ),
     NORWICH    ("te_10" ,"Norwich"    ),
     QPR        ("te_11" ,"QPR"        ),
     READING    ("te_12" ,"Reading"    ),
     SOUTHAMPTON("te_13" ,"Southampton"),
     STOKE_CITY ("te_14" ,"Stoke City" ),
     SUNDERLAND ("te_15" ,"Sunderland" ),
     SWANSEA    ("te_16" ,"Swansea"    ),
     TOTTENHAM  ("te_17" ,"Tottenham"  ),
     WEST_BROM  ("te_18" ,"West Brom"  ),
     WEST_HAM   ("te_19" ,"West Ham"   ),
     WIGAN      ("te_20" ,"Wigan"      );

     private String teamName;
     private String dropdownSelection;

     private Team(String dropdownSelection, String teamName) {
          this.teamName = teamName;
          this.dropdownSelection = dropdownSelection;
     }

     public String getTeamName() {
          return teamName;
     }

     public String getDropdownSelection() {
          return dropdownSelection;
     }

}
