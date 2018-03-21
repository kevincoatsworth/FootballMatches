import scala.collection.mutable.ListBuffer
import scala.util.Random

object FootballMatch extends App {

  val roundOf32Winners: ListBuffer[String] = new ListBuffer
  val roundOf16Winners: ListBuffer[String] = new ListBuffer
  val quarterFinalWinners: ListBuffer[String] = new ListBuffer
  val semiFinalWinners: ListBuffer[String] = new ListBuffer

  val leagueTeams = List("Newcastle", "Man United", "Man City", "Chelsea", "Arsenal", "Liverpool",
    "Everton", "Watford", "Tottenham", "Stoke City", "West Brom", "Palace", "Huddersfield",
    "Brighton", "Swansea", "Southampton", "West Ham", "Burnley", "Bournemouth", "Leicester")

  val cupTeams = List("Newcastle", "Man United", "Man City", "Chelsea", "Arsenal", "Liverpool",
    "Everton", "Watford", "Tottenham", "Stoke City", "West Brom", "Palace", "Huddersfield",
    "Brighton", "Swansea", "Southampton", "West Ham", "Burnley", "Bournemouth", "Leicester",
    "Millwall", "Sunderland", "Fulham", "Bolton", "Middlesbrough", "Wolves", "Cardiff",
    "Villa", "Derby", "Preston", "Brentford", "Ipswich")

  def footyMatches(): Unit = {

    val shuffledTeams = Random.shuffle(leagueTeams)

    for(i <- 0 to 9) {

      val homeTeamScore = Random.nextInt(5)
      val awayTeamScore = Random.nextInt(5)
      val homeTeam = shuffledTeams(i)
      val awayTeam = shuffledTeams(i+10)

      println(s"$homeTeam $homeTeamScore - $awayTeamScore $awayTeam")

    }
  }

  def leagueCupRoundOf32(): Unit = {

    val shuffledTeams = Random.shuffle(cupTeams)

    for (i <- 0 to 15) {

      val homeTeamScore = Random.nextInt(5)
      val awayTeamScore = Random.nextInt(5)
      val homeTeam = shuffledTeams(i)
      val awayTeam = shuffledTeams(i+16)

      println(s"$homeTeam $homeTeamScore - $awayTeamScore $awayTeam")

      match {

        case _ if homeTeamScore == awayTeamScore => println(s"$homeTeam won by pens")
          roundOf32Winners.append(homeTeam)
        case _ if homeTeamScore > awayTeamScore => roundOf32Winners.append(homeTeam)
        case _ => roundOf32Winners.append(awayTeam)
      }
    }
  }

  def leagueCupRoundOf16(): Unit = {

    val shuffledTeams = Random.shuffle(roundOf32Winners)

    for (i <- 0 to 7) {

      val homeTeamScore = Random.nextInt(5)
      val awayTeamScore = Random.nextInt(5)
      val homeTeam = shuffledTeams(i)
      val awayTeam = shuffledTeams(i+8)

      println(s"$homeTeam $homeTeamScore - $awayTeamScore $awayTeam")

      homeTeamScore match {

        case d if d == awayTeamScore => println(s"$homeTeam won by pens")
          roundOf16Winners.append(homeTeam)
        case _ if homeTeamScore > awayTeamScore => roundOf16Winners.append(homeTeam)
        case _ => roundOf16Winners.append(awayTeam)
      }
    }
  }

  def quarterFinals(): Unit = {

    val shuffledTeams = Random.shuffle(roundOf16Winners)

    for (i <- 0 to 3) {

      val homeTeamScore = Random.nextInt(5)
      val awayTeamScore = Random.nextInt(5)
      val homeTeam = shuffledTeams(i)
      val awayTeam = shuffledTeams(i+4)

      println(s"$homeTeam $homeTeamScore - $awayTeamScore $awayTeam")

      homeTeamScore match {

        case d if d == awayTeamScore => println(s"$homeTeam won by pens")
          quarterFinalWinners.append(homeTeam)
        case _ if homeTeamScore > awayTeamScore => quarterFinalWinners.append(homeTeam)
        case _ => quarterFinalWinners.append(awayTeam)
      }
    }
  }

  def semiFinals(): Unit = {

    val shuffledTeams = Random.shuffle(quarterFinalWinners)

    for (i <- 0 to 1) {

      val homeTeamScore = Random.nextInt(5)
      val awayTeamScore = Random.nextInt(5)
      val homeTeam = shuffledTeams(i)
      val awayTeam = shuffledTeams(i+2)

      println(s"$homeTeam $homeTeamScore - $awayTeamScore $awayTeam")

      homeTeamScore match {

        case d if d == awayTeamScore => println(s"$homeTeam won by pens")
          semiFinalWinners.append(homeTeam)
        case _ if homeTeamScore > awayTeamScore => semiFinalWinners.append(homeTeam)
        case _ => semiFinalWinners.append(awayTeam)
      }
    }
  }

  def cupFinal(): Unit = {

      val shuffledTeams = Random.shuffle(semiFinalWinners)

      val homeTeamScore = Random.nextInt(5)
      val awayTeamScore = Random.nextInt(5)
      val homeTeam = shuffledTeams.head
      val awayTeam = shuffledTeams(1)

      println(s"$homeTeam $homeTeamScore - $awayTeamScore $awayTeam")

      val winner = homeTeamScore match {

        case d if d == awayTeamScore => homeTeam
        case _ if homeTeamScore > awayTeamScore => homeTeam
        case _ => awayTeam
      }

      println(s"The winner of this years' League Cup Final is...$winner")
    }

  def startCup() : Unit = {

    leagueCupRoundOf32()
    println("")
    leagueCupRoundOf16()
    println("")
    quarterFinals()
    println("")
    semiFinals()
    println("")
    cupFinal()
  }

  //footyMatches()
  startCup()

}
