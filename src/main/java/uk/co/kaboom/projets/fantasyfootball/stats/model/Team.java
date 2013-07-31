package uk.co.kaboom.projets.fantasyfootball.stats.model;

public enum Team {
     ARSENAL       ("te_1"  ,"Arsenal"       ),
     ASTON_VILLA   ("te_2"  ,"Aston Villa"   ),
     CARDIFF       ("te_3"  ,"Cardiff City"  ),
     CHELSEA       ("te_4"  ,"Chelsea"       ),
     CRYSTAL_PALACE("te_5"  ,"Crystal Palace"),
     EVERTON       ("te_6"  ,"Everton"       ),
     FULHAM        ("te_7"  ,"Fulham"        ),
     HULL_CITY     ("te_8"  ,"Hull City"     ),
     LIVERPOOL     ("te_9"  ,"Liverpool"     ),
     MAN_CITY      ("te_10" ,"Man City"      ),
     MAN_UTD       ("te_11" ,"Man Utd"       ),
     NEWCASTLE     ("te_12" ,"Newcastle"     ),
     NORWICH       ("te_13" ,"Norwich"       ),
     SOUTHAMPTON   ("te_14" ,"Southampton"   ),
     STOKE_CITY    ("te_15" ,"Stoke City"    ),
     SUNDERLAND    ("te_16" ,"Sunderland"    ),
     SWANSEA       ("te_17" ,"Swansea"       ),
     TOTTENHAM     ("te_18" ,"Tottenham"     ),
     WEST_BROM     ("te_19" ,"West Brom"     ),
     WEST_HAM      ("te_20" ,"West Ham"      );

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
