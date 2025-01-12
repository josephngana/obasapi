package repository.users

import domain.users.User
import repository.Repository
import repository.users.impl.cockroachdb

trait UserRepository extends Repository[User]{

}

object UserRepository{
  def roach: UserRepository = new cockroachdb.UserRepositoryImpl()
}
