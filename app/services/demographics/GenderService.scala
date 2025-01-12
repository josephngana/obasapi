package services.demographics

import domain.demographics.Gender
import services.CrudService
import services.demographics.Impl.cockroachdb

trait GenderService extends CrudService[Gender]{

}

object GenderService
{
  def roach: GenderService = new cockroachdb.GenderServiceImpl()
}
