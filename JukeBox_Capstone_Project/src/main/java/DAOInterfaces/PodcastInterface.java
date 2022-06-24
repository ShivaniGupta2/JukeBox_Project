package DAOInterfaces;

import Model.Podcast;


import java.util.List;

public interface PodcastInterface
{
    public void insertNewPodcast() throws Exception;

    List<Podcast> sortAllPodcast(String sortCategory);

    List<Podcast> displayAllPodcast();



}
