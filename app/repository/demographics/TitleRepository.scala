package repository.demographics

import domain.demographics.Title
import repository.Repository
import repository.demographics.impl.cockcroachdb

trait TitleRepository extends Repository [Title]{

}

object TitleRepository{

  def roach: TitleRepository = new cockcroachdb.TitleRepositoryImpl()

}
