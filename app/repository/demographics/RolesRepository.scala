package repository.demographics

import domain.demographics.Roles
import repository.Repository
import repository.demographics.impl.cockcroachdb

trait RolesRepository extends Repository [Roles]{

}
object RolesRepository{

  def roach: RolesRepository= new cockcroachdb.RolesRepositoryImpl()

}
