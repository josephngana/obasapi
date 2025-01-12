package repository.users

import domain.users.UserDocuments
import repository.Repository
import repository.users.impl.cockroachdb

trait UserDocumentsRepository extends Repository[UserDocuments]{

}

object UserDocumentsRepository{
  def roach: UserDocumentsRepository = new cockroachdb.UserDocumentsRepositoryImpl()
}
