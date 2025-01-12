package repository.demographics

import domain.demographics.Race
import repository.Repository
import repository.demographics.impl.cockcroachdb

trait RaceRepository extends Repository [Race]{

}
object RaceRepository{
  def roach: RaceRepository = new cockcroachdb.RaceRepositoryImpl()
}
